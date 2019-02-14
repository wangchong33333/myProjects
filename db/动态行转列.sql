-- 实现语句（不需要存储过程）
SET @SQL = NULL;

SELECT
	GROUP_CONCAT(
		DISTINCT CONCAT(
			"(
				SELECT
					SUM(network_type ='",
			m.network_type,
			"')
				FROM
					app_details b
				WHERE
					b.register_time <= a.register_time
				AND longitude IS NOT NULL
			) ",
			REPLACE (m.network_type, '-', '')
		)
	) INTO @SQL
FROM
	app_details m;


SET @SQL = CONCAT(
	"SELECT
	*
FROM
	(
		SELECT
			register_time,",
	@SQL,
	" FROM
			app_details a
		GROUP BY
			register_time DESC
		LIMIT 6
	) sql1
ORDER BY
	register_time ASC"
);

-- 查看生成的sql
-- SELECT
-- 	@SQL;
-- 
PREPARE stmt
FROM
	@SQL;

-- 动态生成脚本
EXECUTE stmt;

-- 动态执行脚本
DEALLOCATE PREPARE stmt;
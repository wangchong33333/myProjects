import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import HelloWorld1 from '@/components/HelloWorld1'

Vue.use(Router)

function getAbsolutePath () {
  let path = location.pathname
  return path.substring(0, path.lastIndexOf('/') + 1)
}

export default new Router({
  mode: 'history',
  base: getAbsolutePath(), // 只在history下有用
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/hello1',
      name: 'HelloWorld1',
      component: HelloWorld1
    }
  ]
})

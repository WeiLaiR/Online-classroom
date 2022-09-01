import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '后台管理系统', icon: 'dashboard' }
    }]
  },

  // 讲师管理
  {
    path: '/vod',
    component: Layout,
    redirect: '/vod/teacher/list',
    name: 'Teacher',
    meta: {
      title: '讲师管理',
      icon: 'el-icon-bank-card'
    },
    alwaysShow: true,
    children: [
      {
        path: 'teacher/list',
        name: 'TeacherList',
        component: () => import('@/views/vod/teacher/list'),
        meta: { title: '讲师列表' }
      },
      {
        path: 'teacher/create',
        name: 'TeacherCreate',
        component: () => import('@/views/vod/teacher/form'),
        meta: { title: '添加讲师' }
        // hidden: true
      },
      {
        path: 'teacher/edit/:id',
        name: 'TeacherEdit',
        component: () => import('@/views/vod/teacher/form'),
        meta: { title: '编辑讲师' },
        hidden: true
      }
    ]
  },

  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: '课程分类管理',
    alwaysShow: true,
    meta: { title: '课程分类管理', icon: 'example' },
    children: [
      {
        path: 'list',
        name: '课程分类列表',
        component: () => import('@/views/vod/subject/list'),
        meta: { title: '课程分类列表', icon: 'table' }
      }
    ]
  },

  // 课程管理
  {
    path: '/vodcourse',
    component: Layout,
    redirect: '/vod/course/list',
    name: 'Course',
    meta: {
      title: '点播管理',
      icon: 'el-icon-bank-card'
    },
    alwaysShow: true,
    children: [
      {
        path: 'course/list',
        name: 'CourseList',
        component: () => import('@/views/vod/course/list'),
        meta: { title: '课程列表' }
      },
      {
        path: 'course/info',
        name: 'CourseInfo',
        component: () => import('@/views/vod/course/form'),
        meta: { title: '发布课程' },
        hidden: true
      },
      {
        path: 'course/info/:id',
        name: 'CourseInfoEdit',
        component: () => import('@/views/vod/course/form'),
        meta: { title: '编辑课程' },
        hidden: true
      },
      {
        path: 'course/chapter/:id',
        name: 'CourseChapterEdit',
        component: () => import('@/views/vod/course/form'),
        meta: { title: '编辑大纲' },
        hidden: true
      },
      {
        path: 'course/chart/:id',
        name: 'CourseChart',
        component: () => import('@/views/vod/course/chart'),
        meta: { title: '课程统计' },
        hidden: true
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router

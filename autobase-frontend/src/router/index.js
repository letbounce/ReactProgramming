import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Users from '../views/Users.vue';
import Admin from '../views/Admin.vue';
import About from '../views/About.vue';

const routes = [
  { 
    path: '/', 
    name: 'Home', 
    component: Home,
    meta: { title: 'Головна сторінка' }
  },
  { 
    path: '/users', 
    name: 'Users', 
    component: Users,
    meta: { title: 'Користувачі', requiresAuth: false }
  },
  { 
    path: '/admin', 
    name: 'Admin', 
    component: Admin,
    meta: { title: 'Адміністратор', requiresAuth: true, roles: ['ROLE_Admin'] }
  },
  { 
    path: '/about', 
    name: 'About', 
    component: About,
    meta: { title: 'Про нас' }
  },
  // Заглушка для невідомих маршрутів
  { 
    path: '/:pathMatch(.*)*', 
    name: 'NotFound', 
    redirect: '/' 
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// Глобальний навігаційний guard для зміни заголовку сторінки
router.beforeEach((to, from, next) => {
  // Встановлюємо заголовок сторінки
  if (to.meta.title) {
    document.title = `${to.meta.title} - Autobase`;
  } else {
    document.title = 'Autobase';
  }
  
  // Тут можна додати перевірку авторизації
  // if (to.meta.requiresAuth && !isAuthenticated) {
  //   next('/login');
  // } else {
  //   next();
  // }
  
  next();
});

export default router;

<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <!-- Логотип/бренд -->
      <router-link class="navbar-brand" to="/">
        <i class="bi bi-truck-front me-2"></i>Autobase
      </router-link>
      
      <!-- Мобільна кнопка для згортання меню -->
      <button 
        class="navbar-toggler" 
        type="button" 
        data-bs-toggle="collapse" 
        data-bs-target="#navbarNav"
        aria-controls="navbarNav" 
        aria-expanded="false" 
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <!-- Навігаційне меню -->
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto">
          <li class="nav-item">
            <router-link class="nav-link" to="/" active-class="active">
              <i class="bi bi-house me-1"></i>Головна
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/users" active-class="active">
              <i class="bi bi-people me-1"></i>Користувачі
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/admin" active-class="active">
              <i class="bi bi-gear me-1"></i>Адмін
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/about" active-class="active">
              <i class="bi bi-info-circle me-1"></i>Про нас
            </router-link>
          </li>
        </ul>
        
        <!-- Статус авторизації (заглушка) -->
        <div class="navbar-nav">
          <span class="navbar-text text-light">
            <i class="bi bi-person-circle me-1"></i>
            <span v-if="isAuthenticated">Авторизований</span>
            <span v-else>Гість</span>
          </span>
        </div>
      </div>
    </div>
  </nav>
  
  <!-- Основний контент -->
  <main class="min-vh-100">
    <router-view />
  </main>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      isAuthenticated: false, // Заглушка - потім підключимо реальну авторизацію
    };
  },
  // Методи для майбутньої авторизації
  methods: {
    login() {
      // TODO: реалізувати логін
      this.isAuthenticated = true;
    },
    logout() {
      // TODO: реалізувати вихід
      this.isAuthenticated = false;
    },
  },
};
</script>

<style scoped>
/* Стилі для активної навігації */
.nav-link.active {
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 0.375rem;
}

/* Мінімальна висота для main */
.min-vh-100 {
  min-height: calc(100vh - 56px); /* 56px - висота navbar */
}

/* Плавні переходи для hover ефектів */
.nav-link {
  transition: background-color 0.2s ease;
}

.nav-link:hover {
  background-color: rgba(255, 255, 255, 0.05);
  border-radius: 0.375rem;
}
</style>

<style>
/* Базові стилі можна залишити мінімальними — Bootstrap покриває більшість */
</style>

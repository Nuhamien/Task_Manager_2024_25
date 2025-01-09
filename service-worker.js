const CACHE_NAME = 'task-manager-cache-v1';
const URLS_TO_CACHE = [
  '/',
  'index.html',
  'login.html',
  'register.html',
  'task.html',
  'styles.css',
  'task.js',
  'login.js',
  'register.js',
  'https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css', // Example of external resource you want to cache
];

// Install the service worker and cache assets
self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open(CACHE_NAME).then((cache) => {
      console.log('Caching assets');
      return cache.addAll(URLS_TO_CACHE);
    })
  );
});

// Intercept network requests and serve cached assets if offline
self.addEventListener('fetch', (event) => {
    if (event.request.url.includes('/tasks')) { // For API calls
      event.respondWith(
        caches.match(event.request).then((cachedResponse) => {
          if (cachedResponse) {
            return cachedResponse; // Return cached tasks if available
          }
  
          return fetch(event.request).then((networkResponse) => {
            return caches.open(CACHE_NAME).then((cache) => {
              cache.put(event.request, networkResponse.clone()); // Cache new response
              return networkResponse;
            });
          });
        })
      );
    } else {
      // For non-API requests, follow the normal cache behavior
      event.respondWith(
        caches.match(event.request).then((cachedResponse) => {
          return cachedResponse || fetch(event.request);
        })
      );
    }
  });
  

// Delete old cache versions during service worker activation
self.addEventListener('activate', (event) => {
  const cacheWhitelist = [CACHE_NAME];
  event.waitUntil(
    caches.keys().then((cacheNames) => {
      return Promise.all(
        cacheNames.map((cacheName) => {
          if (!cacheWhitelist.includes(cacheName)) {
            return caches.delete(cacheName);
          }
        })
      );
    })
  );
});

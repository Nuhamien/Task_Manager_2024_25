document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('login-form');
  
    form.addEventListener('submit', async (e) => {
      e.preventDefault();
  
      // Get form values
      const username = document.getElementById('username').value.trim();
      const password = document.getElementById('password').value.trim();
  
      // Validate inputs
      if (!username || !password) {
        form.classList.add('was-validated');
        return;
      }
  
      // Prepare data for API call
      const data = { username, password };
  
      try {
        // Make a POST request to the backend API
        const response = await fetch('http://localhost:3000/auth/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(data),
        });
  
        if (response.ok) {
          const result = await response.json();
          alert('Login successful! Redirecting to the task page...');
          
          // Store the JWT token (if provided) in localStorage or cookies
          localStorage.setItem('token', result.access_token);
  
          // Redirect to the task page
          window.location.href = 'index.html';
        } else {
          const error = await response.json();
          alert(`Login failed: ${error.message}`);
        }
      } catch (error) {
        alert(`Error: ${error.message}`);
      }
    });
  });
  
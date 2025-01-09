document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('registration-form');
    
    form.addEventListener('submit', async (e) => {
      e.preventDefault();
  
      // Get form values
      const username = document.getElementById('username').value.trim();
      const password = document.getElementById('password').value.trim();
      const confirmPassword = document.getElementById('confirm-password').value.trim();
  
      // Validate inputs
      if (!username || !password || !confirmPassword) {
        form.classList.add('was-validated');
        return;
      }
  
      if (password !== confirmPassword) {
        alert('Passwords do not match!');
        return;
      }
  
      // Prepare data for API call
      const data = { username, password };
  
      try {
        // Make a POST request to the backend API
        const response = await fetch('http://localhost:3000/auth/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(data),
        });
  
        if (response.ok) {
          alert('Registration successful! Redirecting to login page...');
          window.location.href = 'login.html';
        } else {
          const error = await response.json();
          alert(`Registration failed: ${error.message}`);
        }
      } catch (error) {
        alert(`Error: ${error.message}`);
      }
    });
  });
  
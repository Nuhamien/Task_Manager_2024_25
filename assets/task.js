document.addEventListener('DOMContentLoaded', () => {
  const taskForm = document.getElementById('task-form');
  const taskList = document.getElementById('task-list');
  const taskTitleInput = document.getElementById('task-title');
  const taskDescriptionInput = document.getElementById('task-description');
  const logoutBtn = document.getElementById('logout-btn');
  const apiBaseUrl = 'http://localhost:3000/tasks'; // Base URL for the API
  const token = localStorage.getItem('token'); // JWT token from localStorage
   console.log('Token:', token);

  let editTaskId = null; // ID of the task being edited

  // Redirect to login if token is missing
  if (!token) {
    alert('You are not logged in. Redirecting to login page.');
    window.location.href = 'login.html';
    return;
  }

  // Fetch and render tasks
  const fetchTasks = async () => {
    try {
      const response = await fetch(apiBaseUrl, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) {
        if (response.status === 401) {
          alert('Unauthorized access. Please log in again.');
          localStorage.removeItem('token');
          window.location.href = 'login.html';
        }
        throw new Error(`Error: ${response.status} ${response.statusText}`);
      }

      const tasks = await response.json();
      renderTasks(tasks);
    } catch (error) {
      alert(`Failed to fetch tasks: ${error.message}`);
    }
  };

  // Render tasks in the table
  const renderTasks = (tasks) => {
    taskList.innerHTML = ''; // Clear the current list
    tasks.forEach((task) => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${sanitize(task.title)}</td>
        <td>${sanitize(task.description) || 'No description'}</td>
        <td>${task.completed ? 'Completed' : 'Pending'}</td>
        <td>
          <button class="btn btn-sm btn-primary" onclick="editTask(${task.id}, '${sanitize(
            task.title
          )}', '${sanitize(task.description)}')">Edit</button>
          <button class="btn btn-sm btn-danger" onclick="deleteTask(${task.id})">Delete</button>
        </td>
      `;
      taskList.appendChild(row);
    });
  };

  // Sanitize user input to prevent XSS attacks
  const sanitize = (str) => {
    const tempDiv = document.createElement('div');
    tempDiv.textContent = str;
    return tempDiv.innerHTML;
  };

  // Add or update a task
  taskForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const title = taskTitleInput.value.trim();
    const description = taskDescriptionInput.value.trim();

    if (!title) {
      alert('Task title is required');
      return;
    }

    const taskData = { title, description };

    try {
      const method = editTaskId ? 'PATCH' : 'POST';
      const url = editTaskId ? `${apiBaseUrl}/${editTaskId}` : apiBaseUrl;

      const response = await fetch(url, {
        method,
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(taskData),
      });

      if (!response.ok) {
        if (response.status === 401) {
          alert('Unauthorized action. Please log in again.');
          localStorage.removeItem('token');
          window.location.href = 'login.html';
        }
        throw new Error(`Error: ${response.status} ${response.statusText}`);
      }

      taskTitleInput.value = '';
      taskDescriptionInput.value = '';
      editTaskId = null; // Reset edit mode
      fetchTasks(); // Refresh task list
    } catch (error) {
      alert(`Failed to save task: ${error.message}`);
    }
  });

  // Edit a task
  window.editTask = (id, title, description) => {
    editTaskId = id;
    taskTitleInput.value = title;
    taskDescriptionInput.value = description;
    taskTitleInput.focus(); // Bring focus to the title field
  };

  // Delete a task
  window.deleteTask = async (id) => {
    if (!confirm('Are you sure you want to delete this task?')) {
      return;
    }

    try {
      const response = await fetch(`${apiBaseUrl}/${id}`, {
        method: 'DELETE',
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) {
        if (response.status === 401) {
          alert('Unauthorized action. Please log in again.');
          localStorage.removeItem('token');
          window.location.href = 'login.html';
        }
        throw new Error(`Error: ${response.status} ${response.statusText}`);
      }

      fetchTasks(); // Refresh task list
    } catch (error) {
      alert(`Failed to delete task: ${error.message}`);
    }
  };

  // Logout
  logoutBtn.addEventListener('click', () => {
    localStorage.removeItem('token'); // Remove token
    window.location.href = 'login.html'; // Redirect to login
  });

  // Initialize tasks
  fetchTasks();
});

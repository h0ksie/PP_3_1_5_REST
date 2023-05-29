fetch('/api/v1/users/user')
    .then(response => response.json())
    .then(data => {
        document.querySelector('#navbar-list').innerHTML =
            `<li class="nav-item active font-weight-bold"> ${data.email} </li>
                <li class="nav-item">&nbsp;with roles:&nbsp;</li>
                <li class="nav-item"> ${data.roles.map(role => role.name).join(', ')}</li>`
    })
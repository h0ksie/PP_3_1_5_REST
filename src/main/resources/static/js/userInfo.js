fetch('/api/v1/users/user')
    .then(response => response.json())
    .then(data => {
        document.querySelector('#userInfo').innerHTML =
            `<tr>
                <td>${data.id}</td>
                <td>${data.firstName}</td>
                <td>${data.lastName}</td>
                <td>${data.email}</td>
                <td>${data.roles.map(role => role.name).join(', ')}</td>
            </tr>`
    })
let roleResult = ''

fetch('/api/v1/roles/all-roles')
    .then(response => response.json())
    .then(data => {
        data.forEach(role => {
            roleResult +=
            `<option value="${role.id}"> ${role.name} </option>`
        })
        document.querySelector('#user-roles-new').innerHTML = roleResult
        document.querySelector('#user-roles-delete').innerHTML = roleResult
        document.querySelector('#user-roles-edit').innerHTML = roleResult
    })

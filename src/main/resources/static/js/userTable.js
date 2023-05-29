loadTableData()
function loadTableData() {
    let result = ''

    fetch('/api/v1/admin/all-users')
        .then(response => response.json())
        .then(data => filling(data))
    const filling = (data) => {
        clearTable()
        data.forEach(user => {
            result +=
                `<tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.roles.map(role => role.name).join(', ')}</td>
                    <td>
                        <button type="button" class="btn btn-info" data-toggle="modal" id="user-edit"
                        data-target="#userEdit" data-userid=${user.id}> Edit </button> 
                    </td>
                    <td> 
                        <button type="button" class="btn btn-danger" data-toggle="modal" id="user-delete"
                        data-target="#userDelete" data-userid=${user.id}> Delete </button>
                    </td>
                </tr>`
        })
        document.querySelector('#list-users-tbody').innerHTML = result
    }
}

function clearTable() {
    const tbody = document.querySelector('#list-users-tbody');
    tbody.innerHTML = '';
}
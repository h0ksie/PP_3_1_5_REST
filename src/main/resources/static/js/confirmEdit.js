let form = document.querySelector('#userEditModal')
document.getElementById('btn-edit-submit').addEventListener('click', function (event) {
    let user = {
        id: form.elements.id.value,
        firstName: form.elements.firstName.value,
        lastName: form.elements.lastName.value,
        email: form.elements.email.value,
        password: form.elements.password.value,
        roles: Array.from(form.elements.roles.selectedOptions).map(option => ({id: option.value}))
    }

    fetch('/api/v1/admin/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'X-XSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(user)
    })
        .then(response => {
            if (response.ok) {
                loadTableData();
                $('#userEdit').modal('hide');
            }
        })
})
let deleteForm = document.querySelector('#userDeleteModal')

document.getElementById('btn-delete-submit').addEventListener('click', function (event) {

    fetch('/api/v1/admin/delete', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'X-XSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({
            id: deleteForm.elements.id.value,
            firstName: deleteForm.elements.firstName.value,
            lastName: deleteForm.elements.lastName.value,
            email: deleteForm.elements.email.value,
            password: deleteForm.elements.password.value,
            roles: Array.from(deleteForm.elements.roles.selectedOptions).map(option => ({id: option.value}))
        })
    })
        .then(response => {
            if (response.ok) {
                loadTableData();
                $('#userDelete').modal('hide');
            }
        })
})
let createForm = document.querySelector('#creatingForm')
const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');

document.getElementById('btn-create-submit').addEventListener('click', function (event) {

    fetch('/api/v1/admin/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
            'X-XSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({
            firstName: createForm.elements.firstName.value,
            lastName: createForm.elements.lastName.value,
            email: createForm.elements.email.value,
            password: createForm.elements.password.value,
            roles: Array.from(createForm.elements.roles.selectedOptions).map(option => ({id: option.value}))
        })

    })
        .then(response => {
            if (response.ok) {
                loadTableData()
                $('[href="#usersTab"]').click()
            }
        })
})
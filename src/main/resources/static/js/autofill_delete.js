$('#userDelete').on('shown.bs.modal', function (event) {
    let button = $(event.relatedTarget)
    let userId = button.data('userid')
    if (userId) {
        $.get({
            url: '/api/v1/admin/' + userId,
            success: (data) => {
                let modal = $(this)
                modal.find('#user-id-delete').val(data.id)
                modal.find('#user-firstName-delete').val(data.firstName)
                modal.find('#user-lastName-delete').val(data.lastName)
                modal.find('#user-email-delete').val(data.email)
                modal.find('#user-password-delete').val(data.password)
                modal.find('#user-roles-delete').val(data.roles.map(role => role.id))
            },
            error: function (err) {
                alert(err)
            }
        })
    }
})
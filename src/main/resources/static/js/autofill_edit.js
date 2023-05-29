$('#userEdit').on('shown.bs.modal', function (event) {
    let button = $(event.relatedTarget)
    let userId = button.data('userid')
    if (userId) {
        $.get({
            url: '/api/v1/admin/' + userId,
            success: (data) => {
                let modal = $(this)
                modal.find('#user-id').val(data.id)
                modal.find('#user-firstName').val(data.firstName)
                modal.find('#user-lastName').val(data.lastName)
                modal.find('#user-email').val(data.email)
                modal.find('#user-password').val(data.password)
                modal.find('#user-roles-edit').val(data.roles.map(role => role.id))
            },
            error: function (err) {
                alert(err)
            }
        })
    }
})
$(async function() {
    editUser();
});
function editUser() {
    const editForm = document.forms["formEditUser"];
    editForm.addEventListener("submit", ev => {
        ev.preventDefault();
        const selected_options = document.querySelector('#editUserRoles').selectedOptions;

        let rolesNamesArray = new Array(selected_options.length);
        for (let i = 0; i < selected_options.length; i++) {
            rolesNamesArray[i] = selected_options[i].value;
        }

        fetch("http://localhost:8080/api/user-update/" + editForm.id.value, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: editForm.id.value,
                name: editForm.name.value,
                surname: editForm.surname.value,
                age: editForm.age.value,
                password: editForm.password.value,
                roles: rolesNamesArray
            })
        }).then(() => {
            $('#editFormCloseButton').click();
            allUsers();
        })
    })
}
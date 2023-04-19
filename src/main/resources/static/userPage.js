$(async function () {
    await thisUser();
});

async function thisUser() {
    fetch("http://localhost:8080/api/user")
        .then(res => res.json())
        .then(data => {
            $('#headerUsername').append(data.name);
            let roleList = data.roles.map(role => role.role.substring(5).concat(" ")).toString().replaceAll(",", "");
            $('#headerRoles').append(roleList);

            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                 <td>${data.surname}</td>
                <td>${data.age}</td>
                <td>${roleList}</td>)`;
            $('#userPanelBody').append(user);
        })
}
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>

        <th><h2>Result:<h2></th>




    <tr>
        <td>id</td>
        <td>name</td>
        <td>date</td>
        <td>text</td>
        <td>category</td>

    </tr>

<#list articles as article>


<tr>
    <td><a href="article/${article.id}">${article.id}</a></td>
    <td>${article.name}</td>
    <td>${article.date?string['HH:mm']}</td>

    <td>${article.text}</td>
    <td>${article.category}</td>


    <td><a href="/delete/${article.id}">delete</a></td>
    <td><a href="/update/${article.id}">update</a></td>

</tr>
</#list>
</table>


</body>
</html>
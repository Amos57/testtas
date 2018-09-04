<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>

<form name="article" action="/updateArticle" method="POST">
    <p><h1>id<h1></p>
    <input title="Id" type="text" name="id" value="${article.id}">
<p><h1>Name<h1></p>
    <input title="Name" type="text" name="name" value="${article.name}">
<p><h1>Date<h1></p>
    <input title="Date" type="text" name="date" value="${article.date?string['yyyy-MM-dd HH:mm:ss']}">

    <p><h1>text<h1></p>
    <input title="Text" type="text" name="text" value="${article.text}">

    <p><h1>Category<h1></p>
    <select  name="category">
            <#list categories as category>
                <option name="category">${category.categoryName}</option>
            </#list>
    </select>

    <br>
    <input type="submit" value="OK">

</form>

</body>
</html>
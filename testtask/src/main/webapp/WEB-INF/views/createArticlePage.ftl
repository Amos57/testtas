<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>

<form name="article" action="/addArticle" method="POST">

<p><h1>Name Article<h1></p>
    <input title="Name" type="text" name="name">
<p><h1>Date of publication<h1></p>
    <input title="Date" type="text"  value="${.now?string['yyyy-MM-dd HH:mm:ss']}" name="date">
    <p><h1>Content of article<h1></p>
    <input title="Text" type="text" name="text">
<p><h1>Categories<h1></p>
   <select  name="category">
            <#list categories as category>
            <option name="${category.categoryName}">${category.categoryName}</option>
            </#list>
    </select>

    <br>
    <input type="submit" value="OK">

</form>

</body>
</html>
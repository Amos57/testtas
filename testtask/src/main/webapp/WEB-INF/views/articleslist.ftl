<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
<tr>

<form name="text" action="/search" method="POST" >
    Search:<input title="Info" type="text" name="info">
<input type="submit" value="Go">
</tr>
</form>
 <tr>
   <th><h2>News<h2></th>


 </tr>
    <tr>
        <td><h4>id</h4></td>
        <td><h4>name</h4></td>
        <td><h4>date</h4></td>
        <td><h4>text</h4></td>
        <td><h4>category</h4></td>

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

<a href="/addArticle">Create article</a>
</body>
</html>
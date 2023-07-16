<!DOCTYPE html>
<html>
<head>
    <title>Редоктирование транспорта</title>
</head>
<body>
<h1>Edit Transport</h1>
<#if transport??>
    ${transport.id}

    <form action="/edit/${transport.id}" method="POST">
        Марка: <input type="text" name="brand" placeholder="Brand" value="${transport.brand}">
        Модель: <input type="text" name="model" placeholder="Model" value="${transport.model}">
        Категория: <input type="text" name="category" placeholder="Category" value="${transport.category}">
        Государственный номер: <input type="text" name="licensePlate" placeholder="License Plate"
                                      value="${transport.licensePlate}">
        Тип ТС: <select name="vehicleType">
            <option value="Грузовой">Грузовой</option>
            <option value="Легковой">Легковой</option>
            <option value="Motorcycle">Motorcycle</option>
            <option value="Bicycle">Bicycle</option>
            value="${transport.vehicleType}"
        </select>
        Год выпуска: <input type="number" name="year" placeholder="Year" value="${transport.year}">
        <input type="checkbox" name="hasTrailer" <#if transport.hasTrailer>checked</#if>> Has Trailer
        <input type="submit" value="Save">
    </form>
    <br>
</#if>
<#if error??>
    <p>${error}</p>
</#if>
<br>
<button onclick="location.href='/'">Закрыть редактирование</button>
</body>
</html>
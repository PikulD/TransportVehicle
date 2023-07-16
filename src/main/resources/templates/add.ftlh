<!DOCTYPE html>
<head>
    <title>Add Transport</title>
</head>
<body>
<h1>Add Transport</h1>
<form action="/add" method="post">
    Марка: <input type="text" name="brand"/><br><br>
    Модель: <input type="text" name="model"/><br><br>
    Категория: <input type="text" name="category"/><br><br>
    Государственный номер: <input type="text" name="licensePlate"/><br><br>
    Год выпуска: <input type="number" name="year"/><br><br>
    Наличие прицепа: <input type="checkbox" name="hasTrailer"/><br><br>
    Тип ТС: <select name="vehicleType">
        <option value="Грузовой">Грузовой</option>
        <option value="Легковой">Легковой</option>
        <option value="Motorcycle">Motorcycle</option>
        <option value="Bicycle">Bicycle</option>
    </select>
    <input type="submit" value="Добавить автомобиль">
</form>
<br>
<#if error??>
    <p>${error}</p>
</#if>
<br>
<button onclick="location.href='/'">Закрыть добавление</button>
</body>
</html>



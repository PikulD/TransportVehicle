<!DOCTYPE html>

<head>
    <title>
        Транспорта
    </title>
</head>
<body>
<h1> Транспорта </h1>

<button onclick="location.href='/add'">Добавить</button>
<br><br>
<#if transports?has_content>
    <table>
        <tr>
            <th>Марка</th>
            <th>Модель</th>
            <th>Категория</th>
            <th>Государственный номер</th>
            <th>Тип ТС</th>
            <th>Год выпуска</th>
            <th>Наличие прицепа</th>
        </tr>
        <#list transports as transport>
            <tr>
                <th>${transport.brand}</th>
                <th>${transport.model}</th>
                <th>${transport.category}</th>
                <th>${transport.licensePlate}</th>
                <th>${transport.vehicleType}</th>
                <th>${transport.year}</th>
                <th><input type="checkbox" <#if transport.hasTrailer>checked</#if> disabled></th>
                <th><a href="/edit/${transport.id}"> Изменить </a></th>
            </tr>
        </#list>
    </table>
<#else >
    <h1>Нет транспорта </h1>
</#if>
<br>
<h1>Поиск </h1>
<form action="/search" method="get">
    Поиск по марке: <input type="text" name="brand"/><br><br>
    Модель: <input type="text" name="model"/><br><br>
    Категория: <input type="text" name="category"/><br><br>
    Государственный номер: <input type="text" name="licensePlate"/><br><br>
    Год выпуска: <input type="number" name="year" value="0"/><br><br>
    <input type="submit" value="Поиск автомобиль">
</form>
<br>
<button onclick="location.href='/'">Закрыть поиск</button>
</body>
</html>

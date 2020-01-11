<html>
    <head>
        <title>Sumar dos Numeros JavaScript</title>
    </head>
    <body>
    <fieldset>
        <legend>Ingrese dos numeros</legend>
        <label for="">Numero 1:</label>
        <input type="text" id="txtN1">
        <br><br>
        <label for="">Numero 2:</label>
        <input type="text" id="txtN2">
        <br><br>
        <input type="button" onclick="Sumar();" value="Calucular">
    </fieldset>
    </body>
    <script>
        function Sumar() {
            var n1 = document.getElementById('txtN1').value;
            var n2 = document.getElementById('txtN2').value;
            var suma = parseInt(n1) + parseInt(n2);
            alert("La suma es: "+suma)
        }
    </script>
</html>
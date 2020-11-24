       <!DOCTYPE html>
       <html lang="en">
       <head>
         <title>Temperature Conversion Application</title>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
       </head>
       <body>

       <div class="container">
         <h2 text-align: center>Temperature Conversion Application</h2>
         <br> </br>
         <g:form>
           <div class="form-group">
             Celsius: <g:fieldValue bean="${temperatureResponse}" field="celsius"/><br/>
             Fahrenheit: <g:fieldValue bean="${temperatureResponse}" field="fahrenheit"/><br/>
           </div>
         </g:form>
       </div>

       </body>
       </html>

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
  <g:form controller="temperature" action="convert">
    <div class="form-group">
      <label for="property">Property:</label>
      <g:textField class="form-control" id="property" placeholder="Enter Celsius or Fahrenheit" name="property" size="12"/>
    </div>
    <div class="form-group">
      <label>Value:</label>
      <g:textField class="form-control" id="val" placeholder="Enter value" name="val" size="3"/>
    </div>
    <g:actionSubmit class="btn btn-primary" value="Convert"/>
  </g:form>
</div>

</body>
</html>

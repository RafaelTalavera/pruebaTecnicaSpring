# PruebaTecnica
Proyecto para prueba técnica de springboot

El proyecto ha sido creado a través de spring initializr: https://start.spring.io
<br>
Se ha implementado la librería ModelMapper para facilitar las operaciones entre Entitys y DTOs: http://modelmapper.org

Lista de WS:
<ul>
  Categorias:
    <li>GET /categoria?id={idCategoria} </li>
    <li>POST /categoria </li>
    <li>DELETE /categoria?id={idCategoria} </li>
    <li>PUT /categoria </li>
  Productos:
    <li>GET /productos?id={idProducto}</li>
    <li>POST /productos</li>
    <li>DELETE /productos?id={idProducto}</li>
    <li>PUT /productos</li>
  Compras:
    <li>GET /compras?id={idCompras}</li>
    <li>POST /compras?id={idCliente}</li>
    <li>GET /comprasUsuario?id={idCliente}</li>
   Clientes:
    <li>GET /cliente?id={idCliente}</li>
    <li>POST /cliente</li>
    <li>PUT /cliente</li>
</ul>

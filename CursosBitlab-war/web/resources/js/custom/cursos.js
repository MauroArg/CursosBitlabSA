/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#frmAgregarCurso').hide();
    
    $(document).on('click', '.btnAgregar', function () {
        $('#frmAgregarCurso').slideDown();
    });
    $(document).on('click', '.btncacelar', function () {
        $('#frmAgregarCurso').slideUp();
    });


})

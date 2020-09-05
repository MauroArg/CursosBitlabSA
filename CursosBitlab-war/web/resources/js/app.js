var showMenuBox = false;
$(document).ready(function(){
    initFunction();
    $('#requests').slideDown(300);
    
    $('.menu-box').hide(0);
    $('.menu-box').css('right','-350px');
    $('.menu').click(function(){
        toggleMenu();
    });
});



let toggleMenu=()=>{
    if(showMenuBox){
        $('.menu-box').hide(300);
        $('.menu-box').css('right','-350px');
        $('.menu').show(100);
        showMenuBox = false;
    }else{
        $('.menu-box').show(100);
        $('.menu-box').css('right','0px');
        $('.menu').hide(100);
        showMenuBox = true;
    }
}

let initFunction=()=>{
    $('#courses').slideUp(0);
    $('#requests').slideUp(0);
    $('#profile').slideUp(0);
    $('#habilidades').slideUp(0);
}

let showProfile=()=>{
    $('#courses').slideUp(0);
    $('#requests').slideUp(0);
    $('#profile').slideDown(300);
    toggleMenu();
}

let showCourses=()=>{
    $('#courses').slideDown(300);
    $('#requests').slideUp(0);
    $('#profile').slideUp(0);
    toggleMenu();
}

let showRequests=()=>{
    $('#courses').slideUp(0);
    $('#requests').slideDown(300);
    $('#profile').slideUp(0);
    toggleMenu();
}

let showHabilidades=()=>{
    $('#courses').slideUp(0);
    $('#requests').slideUp(0);
    $('#profile').slideUp(0);
    $('#habilidades').slideDown(300);
    toggleMenu();
}
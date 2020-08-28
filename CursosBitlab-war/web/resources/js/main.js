var showMenuBox = false;

$(document).ready(function(){
    
    initFunction();
    $('#requests').slideDown(300);
    
    $('.menu-box').hide(0);
    $('.menu-box').css('right','-350px');
    $('.menu').click(function(){
        toggleMenu();
    });
    
    $('.log-in').slideUp(0);
    $('.register-card').hide(0);
    $('.second-part').hide(0);

    $('.showLogin').click(function(){
        $('.menu-bar').slideUp(200);
        $('.log-in').slideDown(300);
        $('.courses').css('display','none');
    });

    $('.hideLogin').click(function(){
        $('.log-in').slideUp(300);
        $('.menu-bar').slideDown(300);
        $('.courses').css('display','flex');
        $('.register-card').hide(0);
        $('.login-card').show(300).delay(100);
        toFirstPart(0);
    });


    $('#register').click(function(){
        $('.login-card').hide(300);
        $('.register-card').show(300).delay(300);
    });

    $('#toLogin').click(function(){
        $('.register-card').hide(300);
        $('.login-card').show(300).delay(300);
    });

    $('.toSecondPart').click(function(){
        toSecondPart();
    });

    $('.toFirstPart').click(function(){
        toFirstPart(300);
    });
});



let iniAnimations=()=>{
}

let toFirstPart=(time)=>{
    $('.second-part').hide(time);
    $('.first-part').show(time);
}

let toSecondPart=()=>{
    $('.first-part').hide(300);
    $('.second-part').show(300);
}

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


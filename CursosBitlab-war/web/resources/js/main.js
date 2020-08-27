$(document).ready(function(){
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

    $('.apply').click(function(){
        alert('diste click bb, en mi corazón');
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



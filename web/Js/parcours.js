$(document).ready(function () {
 var opts="";
    loadCmbx();
    $('.btnadd').click(function () {
        $.ajax({
            url: 'parcours',
            data: {
                action: 'planifier'
            },
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function (response) {
              
               opts = "<option value=''>selectionnez un obstacle</option>";
                for (i = 0; i < response.length; i++) {
                
                    opts += "<option value='" + response[i].id+"'>" + response[i].nomObstacle + "</option>";
                }
           
            }
        
        });
        
            var render = '<div class="row"> <br>' +
                '<div class="col-md-12"> <br>' +
                '<select name="obs" id="obs" class="form-control obs">' + opts + '</select>' +
                '</div>'+
                '<div class="col-md-12"> <br>' +
                '<input type="button" name="remove" id="rm" value="supprimer" class="remove"/>' +
                '</div>' +
                '</div>';
        
             $('.addObstacle').append(render);

    });
    
     
    /*
     $('.btnaddSoldIns').click(function () {
        $.ajax({
            url: 'parcours',
            data: {
                action: 'planifierSold'
            },
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function (response) {
              
               opts = "<option value=''>selectionnez un soldat</option>";
                for (i = 0; i < response.length; i++) {
                
                    opts += "<option value='" + response[i].id+"'>" + response[i].matricule + "</option>";
                }
           
            }
        
        });
   
            var render = '<div class="row"> <br>' +
                '<div class="col-md-12"> <br>' +
                '<select id="soldIns" id="soldIns" class="form-control">' + opts + '</select>' +
                '</div>'+
                '<div class="col-md-12"> <br>' +
                '<input type="button" name="remove" id="rm" value="supprimer" class="remove"/>' +
                '</div>' +
                '</div>';
        
             $('.addProd').append(render);

    });
    */
     $('.btnaddSold').click(function () {
       
        $.ajax({
            url: 'parcours',
            data: {
                action: 'loadIntructeur'
            },
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function (response) {
              
               opts = "<option value=''>selectionnez un soldat</option>";
                for (i = 0; i < response.length; i++) {
                
                    opts += "<option value='" + response[i].id+"'>" + response[i].matricule + "</option>";
                }
           
            }
        
        });
   
            var render = '<div class="row"> <br>' +
                    '<div class="col-md-12"> <br>' +
                    '<select id="sold" name="sold" class="form-control sold">' + opts + '</select>' +
                    '</div>'+
                '<div class="col-md-12"> <br>' +
                '<input type="number" id="note" name="note" class="form-control sold">' +
                '</div>'+
                    '<div class="col-md-12"> <br>' +
                    '<input type="button" name="remove" id="rm" value="supprimer" class="remove"/>' +
                    '</div>' +
                '</div>';
        
             $('.addSoldat').append(render);

    });
    
    function addPlaning(numPassage,date,obstacle,soldat,instructeur)
    {
         $.ajax({
            url: 'parcours?numPassage=' + numPassage + '&date=' + date + '&obstacle=' + obstacle + '&soldat=' + soldat+
                    '&instructeur='+instructeur,
            data: {
                action: 'addPlaning'
               
            },
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function (result) {
                alert("Planning succes");
            }
            ,
            error: function (errorMessage){
                alert("echec");
                alert(errorMessage.responseText);
            }
        
        });
        
    }
    
    //Load Planing
    $('#enregistrer').click(function () {
      var numpassage;
      var obstacle;
      var soldat;
      var note;
      var user;
      var date;
      var instructeur;
      
     numpassage=$("#numPassage").val();
       date=$("#date").val();
       instructeur=$("#instructeur").val();
       $(".sold").each(function (){
             soldat=$(this).val();
             
           $(".obs").each(function (){
           obstacle= $(this).val();
          
                addPlaning(numpassage,date,obstacle,soldat,instructeur);
           });
         
         
       });
      
       
     
        });
   
            

    

    $('.addProduit').on('blur','.quantite',function(){ 
     if($(this).val()===""){
            return ;
     }
     if(parseInt($(this).val()<0))
     {
         alert("La quantité ne doit pas etre negative");
            return ;
     }
     //alert($(this).parent('div').parent('div').find('.prod').val());
   
     if(!$(this).parent('div').parent('div').find('.prod').val())
     {
         alert("Vous devriez selectionner un produit");
            return ;
     }
     var prix=$(this).parent('div').parent('div').find('.prod').val().split('-');
     $(this).parent('div').parent('div').find('.totale').val($(this).val()*prix[1]);
     
    });
    
    $("#valider").click(function (){
        if($('.prod').length===0)
        {
            alert("Selectionnez au moins un produit");
            return false;
        }
        var data=[];
        var correct=true;
        var message=[];
        var j=0;
        $('.prod').each(function (i){
           data[i]=$(this).val();
           if(data[i]==="")
           {
               
               $(this).css("background","orange");
               message[j]=i;
               j++;
               correct=false;
               
           }
           else
           {
                 $(this).css("background","white");
           }
           
        });
        if(!correct)
        {
            alert("Les produits numéros "+ message.join(", ")+" sont obligatoires");
            return false;
        }
        var unique=data.filter((v,i,a)=>a.indexOf(v) === i);
        if(data.length!==unique.length)
        {
            alert("Impossible de selectionner un produit plusieurs fois");
            return false;
        }
        return true;
        
    });

});

//Load Combo
                            function loadCmbx() {
                                jQuery.ajax({
                                    url: "parcours",
                                    data: {
                                        action: 'LoaaPassage'
                                    },
                                    method: 'GET',
                                    dataType: 'json',
                                    async: false,
                                    success: function (result) {
                                        var v = '';
                                        html = '<option selected>---Choisir Obstacle---</option>';
                                        jQuery.each(result, function (key, val) {
                                            v += '<option value="' + val.id + '">' + val.matricule+ '</option>';

                                        });
                                        jQuery('#passage').html(v);
                                    }
                                });

                            }
    
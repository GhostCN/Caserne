$(document).ready(function () {
 var opts="";

    $('.btnadd').click(function () {
        $.ajax({
            url: "addProduit",
            data: {
                action: 'chooseProd'
            },
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function (response) {
               opts = "<option value=''>selectionnez un produit</option>";
                for (i = 0; i < response.length; i++) {
                //    alert(response[i].designation);
                    opts += "<option value='" + response[i].id+"-"+response[i].pu + "'>" + response[i].designation + "</option>";
                }
           
            }
        });
        var render = '<div class="row">' +
                '<div class="col-md-3">' +
                '<select name="prod" id="prod" class="prod">' + opts + '</select>' +
                '</div>' +
                '<div class="col-md-3">' +
                '<input type="number" name="qte" id="qte" placeholder="Saisir la quantite" class="quantite"/>' +
                '</div>' +
                '<div class="col-md-3">' +
                '<input type="number" name="total" id="total" placeholder="Total" class="totale"/>' +
                '</div>' +
                '<div class="col-md-3">' +
                '<input type="button" name="remove" id="rm" value="supprimer" class="remove"/>' +
                '</div>' +
                '</div>';
        
             $('.addProduit').append(render);

    });

    $('.addProduit').on('blur','.quantite',function(){
     
     if($(this).val()==""){
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
        if($('.prod').length==0)
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
           if(data[i]=="")
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
        if(data.length!=unique.length)
        {
            alert("Impossible de selectionner un produit plusieurs fois");
            return false;
        }
        return true;
        
    });

});
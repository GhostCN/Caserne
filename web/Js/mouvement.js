
var app = angular.module("stock", []);

app.controller('mouvementController', ['$scope', '$http', function ($scope, $http) {
        $scope.loadProduit = function () {

            $http({
                url: "addProduit?action=findMouvement&prod=" + $scope.prod,
                //method: "GET",
                dataType: "json",
                //   data: {action: "findMouvement", prod: $scope.prod}

            }).then(function (response) {
                //alert(response.data.id);
                $scope.qteIni = response.data.qteFinal;
                if ($scope.qteM == "entree")
                {
                    $scope.qteFin = $scope.qteIni + $scope.qteM;

                }

            }, function () {

            });


            // alert("cc");
        };


        $scope.calQteFinal = function () {
            if ($scope.qteM != "")
            {
             
                if($scope.typeM=="entree"){
                    
                    $scope.qteFin = $scope.qteIni + $scope.qteM;
                }
                else{
                    $scope.qteFin = $scope.qteIni - $scope.qteM;
                }
                
            }
        }

        $scope.validerForm = function () {
            

                    // return false;
        }

    }]);

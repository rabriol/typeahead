app.controller('TypeAheadController', ['TypeAheadAPI', '$scope',

    function(TypeAheadAPI, $scope) {

        $scope.onBlur = function() {

            if ($scope.word) {
                TypeAheadAPI.save($scope.word);
            }
        }

        $scope.onChange = function() {
             if ($scope.word) {
                 TypeAheadAPI.predict($scope.word).then(

                     function(data) {

                        $scope.predictions = data;
                        console.log(data)

                     },

                     function (reason) {
                     }
                 );
             } else {
                 $scope.predictions = [];
             }
        }
}]);
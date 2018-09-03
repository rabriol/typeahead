app.directive( 'callRoute', function ( $location ) {

    return function ( scope, element, attrs ) {
        var path;

        attrs.$observe( 'callRoute', function (val) {
            path = val;
        });

        element.bind( 'click', function () {
            scope.$apply( function () {
                $location.path( path );
            });
        });
    };
});
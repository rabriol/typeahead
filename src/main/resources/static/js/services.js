app.service('TypeAheadAPI', function ($http, $q) {

        this.save = function(word) {
            return this.httpClient('POST', 'http://localhost:8081/api/predict/' + window.encodeURIComponent(word))
        };

        this.predict = function(word) {
            return this.httpClient('GET', 'http://localhost:8081/api/predict/' + window.encodeURIComponent(word))
        }

        this.httpClient = function(m, u) {
            var deferred = $q.defer();

            $http({
                method: m,
                url: u})
                .then(function (response) {
                    if ( response.status !== 200) {
                        return [];
                    }
                    deferred.resolve(response.data);

                }, function (err) {
                    deferred.reject('error when calling TypeAheadAPI')
                });

            return deferred.promise;
        }
    }
);

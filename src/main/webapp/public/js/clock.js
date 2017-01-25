/**
 * Created by DreamYao on 2017/1/25.
 */
function MyController($scope) {
    $scope.clock = {
        now: new Date()
    };
    var updateClock = function () {
        $scope.clock.now = new Date()
    };
    setInterval(function () {
        $scope.$apply(updateClock());
    }, 1000);
    updateClock();
};

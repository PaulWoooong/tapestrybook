Tapestry.Validator = {

    alphanumeric : function(field, message){
        var regexp = new RegExp('[a-zA-Z0-9]+');

        field.addValidator(function(value){
            if (! regexp.test(value)){
               throw message;
            }
        });
    }
};

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>myTest</title>
</head>
<script language="JavaScript">
    function pasta(grain, width, shape, hasEgg)
    {
        this.grain = function(){
            for(i=0;i<5;i++){
                alert(i)
            }
        };
        this.width = width;
        this.shape = shape;
        this.hasEgg = hasEgg;
        this.toString = pastaToString(width,shape,hasEgg);
        alert(toString);

    }

    function pastaToString(width,shape,hasEgg)
    {
        return "width: " + this.width + "\n" +
                "shape: " + this.shape + "\n" +
                "hasEgg: " + this.hasEgg;
    }




</script>
<body onload="pasta(1,2,3,4);">


</body>
</html>
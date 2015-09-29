<!DOCTYPE html>
<html>
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- Mobile viewport optimized: h5bp.com/viewport -->
<meta name="viewport" content="width=device-width">

<title>Money Transfer</title>

<!-- remove or comment this line if you want to use the local fonts -->
<link href="./Main_page/css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="./Main_page/bootmetro.css">
<link rel="stylesheet" type="text/css"
	href="./Main_page/bootmetro-responsive.css">
<link rel="stylesheet" type="text/css"
	href="./Main_page/bootmetro-icons.css">
<link rel="stylesheet" type="text/css"
	href="./Main_page/bootmetro-ui-light.css">
<link rel="stylesheet" type="text/css" href="./Main_page/datepicker.css">

<!--  these two css are to use only for documentation -->
<link rel="stylesheet" type="text/css" href="./Main_page/site.css">

<!-- Le fav and touch icons -->
<link rel="shortcut icon"
	href="http://aozora.github.io/bootmetro/assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://aozora.github.io/bootmetro/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://aozora.github.io/bootmetro/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://aozora.github.io/bootmetro/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="http://aozora.github.io/bootmetro/assets/ico/apple-touch-icon-57-precomposed.png">



<!-- All JavaScript at the bottom, except for Modernizr and Respond.
      Modernizr enables HTML5 elements & feature detects; Respond is a polyfill for min/max-width CSS3 Media Queries
      For optimal performance, use a custom Modernizr build: www.modernizr.com/download/ -->
<script type="text/javascript" async="" src="./Main_page/ga.js"></script>
<script src="./Main_page/modernizr-2.6.2.min.js"></script>


<!-- <script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-3182578-6' ]);
	_gaq.push([ '_trackPageview' ]);
	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script> -->

</head>

<body>

	<form action="/sg-fund-transfer" method="post">
		<input type="submit" value="Logout"
			style="margin-left: 1250px; background-color: transparent;" />
	</form>
	<!--[if lt IE 7]>
   <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
   <![endif]-->

	<!-- Header
   ================================================== -->





	<div class="container">
		<div class="row">
			<div class="span12">


				<div class="listview grid-layout">

					<a class="listview-item bg-color-blue" href="" data-toggle="modal"
						data-target="#myModal">
						<div class="listview-item-body"
							style="text-align: center; font-weight: bold;">
							<h4 class="listview-item-heading">Money Transfer</h4>
						</div>
						<div style="text-align: center;">
							<div style="width: 100px;">
								<img alt="image" style="margin-top: 40px"
									src="images/dollor.png">
							</div>
						</div>
					</a>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true"></span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Transaction
										Details</h4>
								</div>
								<form action="transferAmount" method="POST">
									<div class="modal-body" style="background-color: whitesmoke;">
										<table>
											<tr>
												<td><lable>Account Number:</lable></td>
												<td><input type="text" id="acc_no" name="acc_no" /></td>
											</tr>
											<tr>
												<td><lable>Amount:</lable></td>
												<td><input type="text" id="amount" name="amount" /></td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">Transact</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancel</button>

									</div>
								</form>
							</div>
						</div>
					</div>


					<a class="listview-item bg-color-blue" href="">
						<div class="listview-item-body" style="text-align: center;">
							<h4 class="listview-item-heading">Follow on facebook</h4>
						</div>
						<div style="text-align: center;">
							<div style="width: 100px;">
								<img alt="image" style="margin-top: 40px" src="images/fb.png">
							</div>
						</div>
					</a> <a class="listview-item bg-color-blue" href="">
						<div class="listview-item-body" style="text-align: center;">
							<h4 class="listview-item-heading">Follow on twitter</h4>
						</div>
						<div style="text-align: center;">
							<div style="width: 100px;">
								<img alt="image" style="margin-top: 40px"
									src="images/twitter.png">
							</div>
						</div>
					</a>







				</div>

			</div>
		</div>

	</div>

	<c:if test="${Error}">
	<div align="left" style="margin-left: 250px;">
	<span class="label label-danger" style="background-color: transparent;color: #B43104;">${requestScope.Error}</span></div>
		<%-- <label class="error">${requestScope.Error}</label> --%>
	</c:if>
	<c:if test="${mesage}">
	<div align="left" style="margin-left: 200px;">
	<span class="label label-success"  style="background-color: transparent;color: #31B404;">${requestScope.mesage}</span></div>
		<%-- <label class="error">${requestScope.mesage}</label> --%>
	</c:if>


	<!-- Grab Google CDN's jQuery. fall back to local if necessary -->
	<script src="./Main_page/jquery-1.10.0.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-1.10.0.min.js'>\x3C/script>")
	</script>

	<!--[if IE 7]>
   <script type="text/javascript" src="assets/js/bootmetro-icons-ie7.js">
   <![endif]-->

	<script type="text/javascript" src="./Main_page/prettify.js"></script>
	<script type="text/javascript" src="./Main_page/bootstrap.min.js"></script>
	<script type="text/javascript" src="./Main_page/bootmetro-panorama.js"></script>
	<script type="text/javascript" src="./Main_page/bootmetro-pivot.js"></script>
	<script type="text/javascript" src="./Main_page/bootmetro-charms.js"></script>
	<script type="text/javascript"
		src="./Main_page/bootstrap-datepicker.js"></script>




</body>
</html>
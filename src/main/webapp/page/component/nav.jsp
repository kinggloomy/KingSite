<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Harlan Manager</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="manager/index">Dash Broad <span class="sr-only">(current)</span></a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Global <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><button id="banner" type="button" class="btn btn-link" onclick="image('BANNER')">Banner</button></li>
						<li><button id="album" type="button" class="btn btn-link" onclick="image('ALBUM')">Album</button></li>
						<li role="separator" class="divider"></li>
						<li><button id="about" type="button" class="btn btn-link">About</button></li>
						<li><button id="reason" type="button" class="btn btn-link">Reason</button></li>
						<li role="separator" class="divider"></li>
						<li><button id="global" type="button" class="btn btn-link">Global Config</button></li>
					</ul>
				</li>
				<li><a id="user_list" href="javascript:void(0)" >User</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Article <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><button id="article_list" type="button" class="btn btn-link">Article List</button></li>
						<li role="separator" class="divider"></li>
						<li><button id="to_add_article" type="button" class="btn btn-link">Add</button></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.userCode} <span class="caret"></span></a>
					<ul class="dropdown-menu">
                        <li><a href="manager/logout">Logout</a></li>
						<li role="separator" class="divider"></li>
                        <li><a href="#">Profile</a></li>
						<li><a href="#">Change Password</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
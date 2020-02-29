import React from 'react';

export default props => (

	<nav className="navbar navbar-expand-lg navbar-dark" style={{background: '#6aa8fd'}}>
		<a className="navbar-brand" href="#">Welcome Dear Customer</a>
		<button className="navbar-toggler"
			type="button"
			data-toggle="collapse"
			data-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup"
			aria-expanded="false"
			aria-label="Toggle navigation"
		>
			<span className="navbar-toggler-icon"></span>
		</button>
		<div id="navbarNavAltMarkup">
			<div className="row">

				<button
					type="button"
					className="btn btn-secondary">
					Income
				</button>
				<button
					class="pr-2"
					type="button"
					className="btn btn-success">
					New Payment
				</button>
				<button
					type="button"
					className="btn btn-warning">
					Cards List
				</button>
				<button
					type="button"
					className="btn btn-outline-danger">
					Logout
				</button>


			</div>
		</div>
	</nav>

	)
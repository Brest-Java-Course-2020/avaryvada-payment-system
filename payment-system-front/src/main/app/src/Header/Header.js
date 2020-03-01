import React from 'react';

export default props => (

	<nav className="d-flex navbar navbar-expand-lg navbar-light justify-content-between flex-nowrap"
		style={{
			height: '15vh',
			background: '#bfdffd'
		}}
	>
		<a className="navbar-brand" href="#">Welcome Dear Customer</a>

		<div>
			<button

				type="button"
				className="btn btn-secondary mr-3 "
				onClick={props.openIncome.bind(null)}
			>
				Income
			</button>

			<button
				type="button"
				className="btn btn-success mr-3"
				onClick={props.newPayment.bind(null)}
			>

				New Payment
			</button>

			<button
				type="button"
				className="btn btn-warning mr-3"
				onClick={props.cardsList.bind(null)}
			>
				Cards List
			</button>

			<button
				type="button"
				className="btn btn-outline-danger mr-3"
			>
				Logout
			</button>

		</div>

	</nav>

)
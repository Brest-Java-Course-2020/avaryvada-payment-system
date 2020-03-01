import React from 'react';
//<!--TODO add querry(post) to save changes. All values in state.-->
export default props => (

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New Income</h5>
					<button type="button" class="close" onClick={props.closeIncome.bind(null)} aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body d-flex">
					<div className="dropdown open pr-5">
						<button className="btn btn-secondary dropdown-toggle"
							type="button"
							id="dropdownMenuButton"
							data-toggle="dropdown"
							aria-haspopup="true"
							aria-expanded="false"
						>
							{props.card}
						</button>
						<div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
							{ props.data.map(item => (
								<button className="dropdown-item"
									onClick={props.setCardNumber.bind(null, item.cardNumber)}
								>
									{item.cardNumber}
								</button>
							))}

						</div>
					</div>

					<div className="input-group mb-3">
						<div className="input-group-prepend">
							<span className="input-group-text">$</span>
						</div>
						<form>
						<input type="number"
							onChange={props.setIncomeValue}
							className="form-control" aria-label="Amount"/>
						</form>
						<div className="input-group-append">
							<span className="input-group-text">.00</span>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" onClick={props.closeIncome.bind(null)}>Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>

)
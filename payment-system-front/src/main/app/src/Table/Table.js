import React from 'react';

export default props => (
<table className="table">
	<thead>
	<tr>
		<th onClick={props.onSort.bind(null, 'cardNumber')}>cardNumber</th>
		<th onClick={props.onSort.bind(null, 'balance')}>balance</th>
		<th onClick={props.onSort.bind(null, 'expense')}>expense</th>
		<th onClick={props.onSort.bind(null, 'block')}>block</th>
		<th>History</th>
	</tr>
	</thead>
	<tbody>
	{ props.data.map(item =>(
		<tr key={item.cardNumber}>
			<td >{item.cardNumber}</td>
			<td>{item.balance}</td>
			<td>{item.expense}</td>
			<td>
				<input
					name="block"
					type="checkbox"
					checked={item.block}/>
			</td>
			<td>
				<button type="button" className="btn btn-info">History</button>
			{/*TODO: create icon!*/}
			</td>
		</tr>
	))}
	</tbody>
</table>
)
import React from 'react';

export default props => (
<table className="table">
	<thead>
	<tr>
		<th>cardNumber</th>
		<th>balance</th>
		<th>expense</th>
		<th>block</th>
	</tr>
	</thead>
	<tbody>
	{ props.data.map(item =>(
		<tr key={item.cardNumber}>
			<td>{item.cardNumber}</td>
			<td>{item.balance}</td>
			<td>{item.expense}</td>
			<td>
				<input
					name="block"
					type="checkbox"
					checked={item.block}/>
			</td>
		</tr>
	))}
	</tbody>
</table>
)
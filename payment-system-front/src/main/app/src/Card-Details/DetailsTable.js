import React from 'react';

export default props => (
	<table className="table">
		<thead>
		<tr>
			<th onClick={props.onSort.bind(null, 'date')}>Date</th>
			<th onClick={props.onSort.bind(null, 'number')}>Payment Number</th>
			<th onClick={props.onSort.bind(null, 'cost')}>Cost</th>
			<th onClick={props.onSort.bind(null, 'description')}>Description</th>
			<th>Edit Description</th>
		</tr>
		</thead>
		<tbody>
		{props.data.map(item => (
			<tr key={item.date}>
				<td>{item.date}</td>
				<td>{item.number}</td>
				<td>{item.cost}</td>
				<td>{item.description}</td>

				<td>
					<button
						type="button"
						className="btn btn-info"
					>
						Edit
					</button>

					{/*TODO: create icon!*/}
				</td>
			</tr>
		))}
		</tbody>
	</table>
)
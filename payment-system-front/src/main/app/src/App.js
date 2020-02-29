import React, {Component} from 'react';
import Loader from './Loader/Loader';
import Table from './Table/Table';

class App extends Component {

	state = {
		isLoading: true,
		data: []
	};

	//after load DOM
	async componentDidMount() {
		//add get (Mock for test?? mb)
		//const response = await fetch(``);
		//const data = await response.json();
		//cardnumber - regexp
		const data = [
			{cardNumber:'visa-4444', balance: 1,  expense: 2, block: false},
			{cardNumber: 'visa-4443', balance: 2,  expense: 12, block: false},
			{cardNumber: 'visa-4442', balance: 3,  expense: 22, block: true},
			{cardNumber:' visa-4441', balance: 4,  expense: 32, block: false},
			{cardNumber: 'visa-4445', balance: 6,  expense: 42, block: true},
			{cardNumber: 'visa-4447', balance: 7,  expense: 52, block: true},
			{cardNumber: 'visa-4449', balance: 9,  expense: 62, block: false}
		]


		console.log(data);
		this.setState({
			isLoading: false,
			data: data
		})
	}

	render() {
		return (
			<div className="container">
				{
					this.state.isLoading
						? <Loader/>					//data loading case
						: <Table 					//data load case
							data={this.state.data}
						/>
				}
			</div>

		);
	}
}

export default App;
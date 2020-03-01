import React, {Component} from 'react';
import Loader from './Loader/Loader';
import Table from './Table/Table';
import sort from 'lodash';
import PaymentTable from './Card-Details/DetailsTable';
import Header from './Header/Header';
import Income from './IncomeModal/Income';

class App extends Component {

	state = {
		isLoading: true,
		data: [],
		sort: 'asc', //def
		sortField: 'id',//def
		row: null, //selected card, null case - all cards list
		newPaymentModalOn: false,
		incomeModalOn: false,
		selectedCardIncome: 'Select Card!',
		incomeValue: 0,
	};

	//after load DOM
	async componentDidMount() {
		//add get (Mock for test?? mb)
		//const response = await fetch(``);
		//const data = await response.json();
		//cardnumber - regexp
		const data = [
			{
				cardNumber: 'visa-4444', balance: 1, expense: 2, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4443', balance: 2, expense: 12, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4442', balance: 3, expense: 22, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: ' visa-4441', balance: 4, expense: 32, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4445', balance: 6, expense: 42, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4447', balance: 7, expense: 52, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4449', balance: 9, expense: 62, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			}
		];


		console.log(data);
		this.setState({
			isLoading: false,
			data: data,
			sort: 'asc',  // 'desc'
			sortField: 'id'
		});
	}

	onSort = sortField => {
		const cloneData = this.state.data.concat(); // save state.data
		const sortType = this.state.sort === 'asc' ? 'desc' : 'asc'; // generate type
		const orderedData = sort.orderBy(cloneData, sortField, sortType); // generate data


		this.setState({//set state
			data: orderedData,
			sort: sortType,
			sortField
		});

		console.log(sortField);
	};

	onRowSelect = row => (
		this.setState({row: row})
	);
	cardsList = row => (
		this.setState({row: null})
	);
	openIncome = incomeModalOn => (
		this.setState({incomeModalOn: true})
	);
	closeIncome = incomeModalOn => (
		this.setState({incomeModalOn: false})
	);
	setCardNumber = selectedCardIncome => {
		this.setState({selectedCardIncome})
	};

	render() {
		return (
			<div className="container">

				<Header
					cardsList={this.cardsList}
					openIncome={this.openIncome}
				/>

				{ // create get for name and add to header
					this.state.incomeModalOn || this.state.newPaymentModalOn
						? <Income
							closeIncome={this.closeIncome}
							data={this.state.data}
							card={this.state.selectedCardIncome}
							incomeValue = {this.state.incomeValue}
							setCardNumber = {this.setCardNumber}
						/>
						: (this.state.isLoading
							? <Loader/>					//data loading case
							: (
								this.state.row ?
									<PaymentTable
										data={this.state.row.payments}
										sort={this.state.sort} //auto sort
										sortField={this.state.sortField} // sort field
										onSort={this.onSort} // sort (ASK MENTOR! without rest)
										onRowSelect={this.onRowSelect} //info about card payment
									/>
									:
									<Table                    //data load case
										data={this.state.data}
										sort={this.state.sort} //auto sort
										sortField={this.state.sortField} // sort field
										onSort={this.onSort} // sort (ASK MENTOR! without rest)
										onRowSelect={this.onRowSelect} //info about card payment
									/>
							)
						)
				}
			</div>

		);
	}

}

export default App;